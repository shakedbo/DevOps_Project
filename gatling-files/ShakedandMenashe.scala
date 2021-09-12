
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ShakedandMenashe extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:8081")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36")

	val headers_0 = Map(
		"sec-ch-ua" -> """Google Chrome";v="93", " Not;A Brand";v="99", "Chromium";v="93""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")



	val scn = scenario("ShakedandMenashe")
		.exec(http("request_0")
			.get("/DevOps_Project/page2.jsp")
			.headers(headers_0))

	setUp(		
			scn.inject(
			nothingFor(5.seconds), 
			rampUsersPerSec(1).to(45).during(10.seconds),
			//constantUsersPerSec(45) during (40.seconds),
			//rampUsersPerSec(45).to(1).during(10.seconds))).protocols(httpProtocol)
}