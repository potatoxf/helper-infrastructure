package potatoxf.helper.basic.starter.common;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.service.Response;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

/**
 * @author potatoxf
 * @date 2022/7/10
 */
@EnableOpenApi
@EnableKnife4j
@Configuration
@ConditionalOnWebApplication
public class Swagger3Configuration {

  @Bean
  public Docket commonDocket(
      @Qualifier("apiMainInfo") ApiInfo apiInfo,
      @Qualifier("apiSecurityScheme") List<SecurityScheme> securitySchemes,
      @Qualifier("apiSecurityContext") List<SecurityContext> securityContexts,
      @Qualifier("apiRequestParameter") List<RequestParameter> requestParameters,
      @Qualifier("apiGetResponse") List<Response> getResponse,
      @Qualifier("apiPostResponse") List<Response> postResponse,
      @Qualifier("apiDeleteResponse") List<Response> deleteResponse,
      @Qualifier("apiPutResponse") List<Response> putResponse,
      @Qualifier("apiPatchResponse") List<Response> patchResponse,
      @Qualifier("apiOptionsResponse") List<Response> optionsResponse,
      @Qualifier("apiTraceResponse") List<Response> traceResponse) {
    return new Docket(DocumentationType.OAS_30)
        .apiInfo(apiInfo)
        .select()
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .paths(PathSelectors.any())
        .build()
        .globalRequestParameters(requestParameters)
        .globalResponses(HttpMethod.GET, getResponse)
        .globalResponses(HttpMethod.POST, postResponse)
        .globalResponses(HttpMethod.DELETE, deleteResponse)
        .globalResponses(HttpMethod.PUT, putResponse)
        .globalResponses(HttpMethod.PATCH, patchResponse)
        .globalResponses(HttpMethod.OPTIONS, optionsResponse)
        .globalResponses(HttpMethod.TRACE, traceResponse)
        // 添加登录认证
        .securitySchemes(securitySchemes)
        .securityContexts(securityContexts);
  }

  /** 构建 api文档的详细信息函数,注意这里的注解引用的是哪个 */
  @ConditionalOnMissingBean
  @Bean(value = "apiMainInfo")
  public ApiInfo apiInfo() {
    return ApiInfo.DEFAULT;
  }
}
