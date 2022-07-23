package potatoxf.helper.basic.app.admin;

import org.springframework.web.bind.annotation.*;

/**
 * @author potatoxf
 * @date 2022/7/13
 */
@RequestMapping("/doc")
@RestController
public class DocController {

  @PostMapping("/template")
  public void template(@RequestParam("username") String username) {
    System.out.println(username);
  }

  @GetMapping(value = "/test", produces = "application/json;charset=utf-8")
  public String test() {
    throw new IllegalArgumentException("参数错误");
  }
}
