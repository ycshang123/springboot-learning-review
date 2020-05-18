package com.soft1851.springboot.quartz.job;
import com.soft1851.springboot.quartz.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * @author ycshang
 * @className DynamicJob
 * @Description TODO
 * @Date 2020/5/18
 * @Version 1.0
 **/
@DisallowConcurrentExecution
@Component
@Slf4j
public class DynamicJob implements Job {
    @Override
    public void execute(JobExecutionContext executorContext) throws JobExecutionException {
        //JobDetail中的JobDataMap是共用的,从getMergedJobDataMap获取的JobDataMap是全新的对象
        JobDataMap map = executorContext.getMergedJobDataMap();
        String jarPath = map.getString("jarPath");
        String parameter = map.getString("parameter");
        String vmParam = map.getString("vmParam");
        log.info("Running Job name : {} ", map.getString("name"));
        log.info("Running Job description : {}", map.getString("jobDescription"));
        log.info("Running Job group: {} ", map.getString("group"));
        log.info(String.format("Running Job cron : %s", map.getString("cronExpression")));
        log.info("Running Job jar path : {} ", jarPath);
        log.info("Running Job parameter : {} ", parameter);
        log.info("Running Job vmParam : {} ", vmParam);
        long startTime = System.currentTimeMillis();
        if (!StringUtils.isEmpty(jarPath)) {
            File jar = new File(jarPath);
            if (jar.exists()) {
                ProcessBuilder processBuilder = new ProcessBuilder();
                processBuilder.directory(jar.getParentFile());
                List<String> commands = new ArrayList<>();
                commands.add("java");
                if (!StringUtils.isEmpty(vmParam)) {
                    commands.add(vmParam);
                }
                commands.add("-jar");
                commands.add(jarPath);
                if (!StringUtils.isEmpty(parameter)) {
                    commands.add(parameter);
                }
                processBuilder.command(commands);
                log.info("Running Job details as follows >>>>>>>>>>>>>>>>>>>>: ");
                log.info("Running Job commands : {}  ", StringUtil.getListString(commands));
                try {
                    Process process = processBuilder.start();
                    logProcess(process.getInputStream(), process.getErrorStream());
                } catch (IOException e) {
                    throw new JobExecutionException(e);
                }
            } else {
                throw new JobExecutionException("Job Jar not found >>  " + jarPath);
            }
        }
        long endTime = System.currentTimeMillis();
        log.info(">>>>>>>>>>>>> Running Job has been completed , cost time : {}ms\n ", (endTime - startTime));
    }

    /**
     * 记录Job执行内容
     *
     * @param inputStream
     * @param errorStream
     * @throws IOException
     */
    private void logProcess(InputStream inputStream, InputStream errorStream) throws IOException {
        String inputLine;
        String errorLine;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
        while (Objects.nonNull(inputLine = inputReader.readLine())) {
            log.info(inputLine);
        }
        while (Objects.nonNull(errorLine = errorReader.readLine())) {
            log.error(errorLine);
        }
    }

}