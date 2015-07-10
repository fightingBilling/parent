package com.lightsoft.hospital;

import java.io.File;
import java.io.IOException;

import org.apache.catalina.Valve;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.RemoteIpValve;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Profile("web")
@Configuration
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private EmbeddedWebApplicationContext server;

	@Autowired
	private Environment environment;

	// @Autowired
	// private TomcatEmbeddedServletContainerFactory servletFactory;

	@Bean
	@Primary
	public ServerProperties serverProperties() {
		ServerProperties serverProperties = new ServerProperties();
		// serverProperties.setPort(8088);
		return serverProperties;
	}

	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).favorParameter(true)
				.parameterName("mediaType").ignoreAcceptHeader(true)
				.useJaf(false).defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML)
				.mediaType("json", MediaType.APPLICATION_JSON);

	}

	@Bean
	public FilterRegistrationBean registration(MyFilter myFilter) {
		FilterRegistrationBean registration = new FilterRegistrationBean(
				myFilter);
		return registration;
	}

	/**
	 * 通过配置tomcat
	 * 
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

		// 添加额外的connectors
		// tomcat.addAdditionalTomcatConnectors(this.createSslConnector());

		// 添加一个valve
		// tomcat.addContextValves(this.createRemoteIpValve());
		return tomcat;
	}

	/**
	 * 构建一个新的remoteIpValve
	 * 
	 * @return
	 */
	private Valve createRemoteIpValve() {
		Valve remoteIpValve = new RemoteIpValve();

		// 写上构建代码

		return remoteIpValve;
	}

	/**
	 * 构建一个新的tomcat connecter
	 * 
	 * @return
	 */
	private Connector createSslConnector() {
		Connector connector = new Connector(
				"org.apache.coyote.http11.Http11NioProtocol");
		Http11NioProtocol protocol = (Http11NioProtocol) connector
				.getProtocolHandler();
		try {
			File keystore = new ClassPathResource("keystore").getFile();
			File truststore = new ClassPathResource("keystore").getFile();
			connector.setScheme("https");
			connector.setSecure(true);
			connector.setPort(8443);
			protocol.setSSLEnabled(true);
			protocol.setKeystoreFile(keystore.getAbsolutePath());
			protocol.setKeystorePass("changeit");
			protocol.setTruststoreFile(truststore.getAbsolutePath());
			protocol.setTruststorePass("changeit");
			protocol.setKeyAlias("apitester");
			return connector;
		} catch (IOException ex) {
			throw new IllegalStateException("can't access keystore: ["
					+ "keystore" + "] or truststore: [" + "keystore" + "]", ex);
		}
	}
}
