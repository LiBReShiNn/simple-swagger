package test;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/swagger")
    public String helloWorld() {
        return "Swagger 왓썹?";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "x", value = "x 값", required = true, dataType = "int", paramType = "path")
            , @ApiImplicitParam(name = "y", value = "y 값", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/plus/{x}")
    public int plus(@PathVariable int x, @RequestParam int y){
        return x + y;
    }

    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일 때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴하는 메소드")
    @GetMapping("/user")
    public User user(User userReq){
        return new User(userReq.getName(), userReq.getAge());
    }

    @PostMapping("/user")
    public User userPost(@RequestBody User req){
        return new User(req.getName(), req.getAge());
    }

}