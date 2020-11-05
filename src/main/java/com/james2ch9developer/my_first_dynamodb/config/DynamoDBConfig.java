package com.james2ch9developer.my_first_dynamodb.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.james2ch9developer.my_first_dynamodb.repository")
public class DynamoDBConfig {

	@Value("${amazon.aws.accesskey}")
	private String awsAccessKey;

	@Value("${amazon.aws.secretkey}")
	private String awsSecretKey;

	@Value("${amazon.dynamodb.region}")
	private String awsRegion;

	@Value("${amazon.dynamodb.endpoint}")
	private String awsDynamoDBEndpoint;

	@Autowired
	private ApplicationContext context;

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
		if (!StringUtils.isEmpty(this.awsDynamoDBEndpoint)) {
			amazonDynamoDB.setEndpoint(this.awsDynamoDBEndpoint);
		}
		return amazonDynamoDB;
	}

	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(this.awsAccessKey, this.awsSecretKey);
	}

	@Bean(name = "mvcHandlerMappingIntrospectorCustom")
	public HandlerMappingIntrospector mvcHandlerMappingIntrospectorCustom() {
		return new HandlerMappingIntrospector(context);
	}
}
