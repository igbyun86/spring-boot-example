package com.ig.springboot.config;

import com.ig.springboot.web.BangsongConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * case 1
     * converter 추가(ConfigurableWebBindingInitializer 빈을 생성하는 방법)
     * @return
     */
    /*
    @Bean
    public ConfigurableWebBindingInitializer initializer() {
        ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        ConfigurableConversionService conversionService = new FormattingConversionService();
        conversionService.addConverter(new BangsongConverter());
        initializer.setConversionService(conversionService);

        return initializer;
    }
*/
    /**
     * case 2
     * converter 추가(WebMvcConfigurer의 메서드를 override하는 방법)
     * @param registry
     */
    /*
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new BangsongConverter());
    }
     */

    /**
     * case 3
     * converter를 bean으로 등록하는 방법
     */
}
