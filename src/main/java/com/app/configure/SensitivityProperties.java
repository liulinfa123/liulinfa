package com.app.configure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ConfigurationProperties
@PropertySource("classpath:sensitivity.properties")
@Data
public class SensitivityProperties {

    private String salt;

    private Boolean enable;

    private List<String> encryptApiField;

    private List<String> decryptApiField;


}
