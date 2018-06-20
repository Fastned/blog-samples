package dfrommi.awsmessaging

import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.AnonymousAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.sns.AmazonSNS
import com.amazonaws.services.sns.AmazonSNSClientBuilder
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("!prod")
class LocalstackConfig {
    val credentialsProvider: AWSCredentialsProvider = AWSStaticCredentialsProvider(AnonymousAWSCredentials())

    @Bean
    fun amazonSNS(): AmazonSNS = AmazonSNSClientBuilder.standard()
//            .withRegion("eu-west-1")
//            .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration(null, "eu-west-1"))
//            .withCredentials(credentialsProvider)
            .build()

    @Bean
    fun amazonSQS(): AmazonSQS = AmazonSQSAsyncClientBuilder.standard()
//            .with
//            .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration(null, "eu-west-1"))
//            .withCredentials(credentialsProvider)
            .build()
}