package releasegrailscrudproject

import grails.plugins.redis.RedisService

class LoggsController {

    RedisService redisService

    def index() {
        [log:redisService.hgetAll("book:one")]
    }

    def delete(){
        redisService.flushDB()
    }
}
