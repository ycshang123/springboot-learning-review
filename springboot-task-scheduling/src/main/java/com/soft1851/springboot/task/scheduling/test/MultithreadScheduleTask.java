package com.soft1851.springboot.task.scheduling.test;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpUtil;
import com.soft1851.springboot.task.scheduling.model.Coder;
import com.soft1851.springboot.task.scheduling.repository.CoderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@EnableScheduling
@Slf4j
public class MultithreadScheduleTask {
    @Resource
    private CoderRepository coderRepository;

    @Async
    @Scheduled(fixedRate = 1000)
    public void first() {
        Console.log("第一个异步定时任务,{},当前线程{}", DateUtil.now(), Thread.currentThread().getName());
    }

    @Async
    @Scheduled(fixedRate = 2000)
    public void second() {
        Console.log("Task two,{}，current thread:{}", RandomUtil.randomInt(10, 100), Thread.currentThread().getName());

    }


    @Async
//    @Scheduled(fixedRate = 2000)
    @Scheduled(cron ="0 26 9 * * ?")
    public void getCode() {
        int index = RandomUtil.randomInt(1, 4);
        Coder coder = coderRepository.findById(index).get();
        download(coder);
    }

    @Async
    public void download(Coder coder) {
        String template = "D:/code/{}.jpg";
        String path = StrUtil.format(template, IdUtil.simpleUUID());
        HttpUtil.downloadFile(coder.getAvatar(), FileUtil.file(path));
        getQrCode(coder.getUrl(),path);
    }

    @Async
    public void getQrCode(String content, String logo) {
        String template = "D:/code/{}.jpg";
        String file = StrUtil.format(template, IdUtil.simpleUUID());
        QrCodeUtil.generate(content, QrConfig.create().setImg(logo), FileUtil.file(file));
    }
}
