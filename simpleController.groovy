@RestController
class Simple{
@RequestMapping("/hello")
 String hello(){
 return "hello boot"
 }
}
