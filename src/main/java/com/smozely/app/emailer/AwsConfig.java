package com.smozely.app.emailer;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.smozely.si.amazon.ses.AmazonSESMessageSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretKey}")
    private String accessKeySecret;

    @Bean
    public AmazonSimpleEmailService sesClient() {
        return new AmazonSimpleEmailServiceClient(new BasicAWSCredentials(accessKeyId, accessKeySecret));
    }

    @Bean
    public AmazonSESMessageSender amazonSESMessageSender() {
        return new AmazonSESMessageSender(sesClient());
    }

}
