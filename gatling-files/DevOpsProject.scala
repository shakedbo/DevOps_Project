
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class DevOpsProject extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:8081")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9,he-IL;q=0.8,he;q=0.7")
		.contentTypeHeader("application/x-www-form-urlencoded")
		.originHeader("http://localhost:8081")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36")

	val headers_0 = Map(
		"Cache-Control" -> "max-age=0",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"sec-ch-ua" -> """Google Chrome";v="93", " Not;A Brand";v="99", "Chromium";v="93""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")



	val scn = scenario("DevOpsProject")
		.exec(http("request_0")
			.post("/DevOps_Project/guru_register")
			.headers(headers_0)
			.formParam("first_name", "shaked")
			.formParam("last_name", "bozi")
			.formParam("username", "sbozi")
			.formParam("password", "ab123456")
			.formParam("address", "hit")
			.formParam("contact", "212121")
			.check(status.is(404)))

	setUp(
		scn.inject(
			nothingFor(5.seconds), 
			atOnceUsers(1),
			//nothingFor(5.seconds), 
			// rampUsers(10).during(10.seconds),
			// rampUsersPerSec(1).to(30).during(15.seconds),
			rampUsersPerSec(1).to(45).during(20.seconds),
			atOnceUsers(45),
			rampUsersPerSec(45).to(1).during(40.seconds)
			//rampUsersPerSec(45).to(1).during(30.seconds)
			//heavisideUsers(45).during(60.seconds),
			//rampUsers(45).during(60 seconds)
		).protocols(httpProtocol)
	)
}
