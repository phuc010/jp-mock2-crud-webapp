package phuc.com.fa.demomvc.controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import phuc.com.fa.demomvc.entity.Car;
import phuc.com.fa.demomvc.page.PageAble;
import phuc.com.fa.demomvc.service.CarServiceImpl;

@Controller
public class HomeController {
    @Autowired
    CarServiceImpl carServiceImpl;

    // Catch the GET request and return the view
    @GetMapping("/index")
    public String home(@RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage, 
            @RequestParam(name = "success", defaultValue = "0") Integer countC,
            @RequestParam(name = "successD", defaultValue = "0") Integer countD,
            Model model) {
        model.addAttribute("totalPages", 0);
        model.addAttribute("success", "[S3M0002I]： "+ countC + " 件の新ﾃﾞﾎﾟ変換情報を更新しました。");
        model.addAttribute("successD", "[S3M0003I]： "+ countD + " 件の新ﾃﾞﾎﾟ変換情報を削除しました。");
        model.addAttribute("countD",countD);
        model.addAttribute("countC", countC);
        return "index";
    }

 // Catch the GET request and return the view
    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
    
    @GetMapping(value = "/downloadFile")
    public void downloadFile(HttpServletResponse response,
    		@RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(name = "メーカー", required = false) String メーカー,
            @RequestParam(name = "搬入場所", required = false) String 搬入場所,
            @RequestParam(name = "manufacturerPartNumber", required = false) String manufacturerPartNumber,
            @RequestParam(name = "出荷デポ", required = false) String 出荷デポ,
            @RequestParam(name = "SS", required = false) String SS,
            @RequestParam(name = "車種", required = false) String 車種,
            @RequestParam(name = "stt", required = false) String stt,
            Model model) throws IOException {
      
      response.setContentType("application/octet-stream");
      response.setHeader("Content-Disposition", "attachment; filename=example.csv");
      List<Car> carList = carServiceImpl.listNoPage( メーカー, 搬入場所,manufacturerPartNumber,出荷デポ,SS,車種);
    }
    
    @GetMapping("/export")
    public String export(@RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(name = "メーカー", required = false) String メーカー,
            @RequestParam(name = "搬入場所", required = false) String 搬入場所,
            @RequestParam(name = "manufacturerPartNumber", required = false) String manufacturerPartNumber,
            @RequestParam(name = "出荷デポ", required = false) String 出荷デポ,
            @RequestParam(name = "SS", required = false) String SS,
            @RequestParam(name = "車種", required = false) String 車種,
            @RequestParam(name = "stt", required = false) String stt,
            Model model) {
        try {
            List<Car> carList = carServiceImpl.listNoPage( メーカー, 搬入場所,manufacturerPartNumber,出荷デポ,SS,車種);
            carServiceImpl.writeFile(carList);
            return "export";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/dangkimoi")
    public String register() {
        return "dangkimoi";
    }

    @PostMapping("/search")
    public String postCurrentPage(@RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(name = "メーカー", required = false) String メーカー,
            @RequestParam(name = "搬入場所", required = false) String 搬入場所,
            @RequestParam(name = "manufacturerPartNumber", required = false) String manufacturerPartNumber,
            @RequestParam(name = "出荷デポ", required = false) String 出荷デポ,
            @RequestParam(name = "SS", required = false) String SS,
            @RequestParam(name = "車種", required = false) String 車種,
            @RequestParam(name = "stt", required = false) String stt,
            @RequestParam(name = "pagesize", defaultValue = "5") Integer pagesize,
            Model model) {
        if (currentPage < 1) {
            currentPage = 1;
        }
        PageAble pageAble = new PageAble(currentPage);
        if (pagesize == 10) {
            pageAble.setSize(10);
        }
        List<Car> carList = null;
        try {
            int totalPages = carServiceImpl.totalPages(pageAble, メーカー, 搬入場所,manufacturerPartNumber,出荷デポ,SS,車種);
            if (currentPage > totalPages ) {
                currentPage = totalPages;
            }
            if (totalPages == 0) {
                model.addAttribute("err", "Err [S3M0003E]：該当するデータが存在しません。");
            }
            carList = carServiceImpl.findWithPageAble(pageAble, "" , "", "", "", "", "");
        } 
        catch (Exception e) {
            return "redirect:/error";
        }
            model.addAttribute("メーカー", メーカー);
            model.addAttribute("搬入場所", 搬入場所);
            model.addAttribute("manufacturerPartNumber", manufacturerPartNumber);
            model.addAttribute("出荷デポ", 出荷デポ);
            model.addAttribute("SS", SS);
            model.addAttribute("車種", 車種);
            model.addAttribute("stt", stt);
            model.addAttribute("carList", carList);
            model.addAttribute("totalPages", carServiceImpl.totalPages(pageAble,メーカー, 搬入場所,manufacturerPartNumber,出荷デポ,SS,車種));
            model.addAttribute("carList", carList);
            model.addAttribute("currentPage", currentPage);
            model.addAttribute("pagesize", pagesize);
            return "redirect:/search";
    }

    @GetMapping("/search") 
    public String search(@RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(name = "メーカー", required = false) String メーカー,
            @RequestParam(name = "搬入場所", required = false) String 搬入場所,
            @RequestParam(name = "manufacturerPartNumber", required = false) String manufacturerPartNumber,
            @RequestParam(name = "出荷デポ", required = false) String 出荷デポ,
            @RequestParam(name = "SS", required = false) String SS,
            @RequestParam(name = "車種", required = false) String 車種,
            @RequestParam(name = "stt", required = false) String stt,
            @RequestParam(name = "change", defaultValue = "0") Integer change,
            @RequestParam(name = "pagesize", defaultValue = "5") Integer pagesize,
            Model model) {
        if (currentPage < 1) {
            currentPage = 1;
        }
        List<Car> carList = null;
        PageAble pageAble = new PageAble(currentPage);
        if (pagesize == 10) {
            pageAble.setSize(10);
        }
        carList = carServiceImpl.findWithPageAble(pageAble, メーカー, 搬入場所,manufacturerPartNumber,出荷デポ,SS,車種);
        int totalPages = carServiceImpl.totalPages(pageAble, メーカー, 搬入場所,manufacturerPartNumber,出荷デポ,SS,車種);
        if (totalPages == 0) {
            model.addAttribute("err", "Err [S3M0003E]：該当するデータが存在しません。");
        }
        model.addAttribute("メーカー", メーカー);
        model.addAttribute("搬入場所", 搬入場所);
        model.addAttribute("manufacturerPartNumber", manufacturerPartNumber);
        model.addAttribute("出荷デポ", 出荷デポ);
        model.addAttribute("SS", SS);
        model.addAttribute("車種", 車種);
        model.addAttribute("stt", stt);
        model.addAttribute("carList", carList);
        model.addAttribute("totalPages", carServiceImpl.totalPages(pageAble, メーカー, 搬入場所,manufacturerPartNumber,出荷デポ,SS,車種));
        model.addAttribute("carList", carList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pagesize", pagesize);
        return "index";
    }

    @PostMapping("/update")
    public String update(@RequestParam(value="cdnewQty") String[] cdnewQty,
            @RequestParam(value = "stt") String[] stt,
            @RequestParam(value = "メーカー") String[] メーカー,
            @RequestParam(value = "メーカー名") String[] メーカー名,
            @RequestParam(value = "SS") String[] SS,
            @RequestParam(value = "SS名") String[] SS名,
            @RequestParam(value = "搬入場所") String[] 搬入場所,
            @RequestParam(value = "newQty") String[] newQty,
            @RequestParam(value = "oldQty") String[] oldQty,
            @RequestParam(value = "manufacturerPartNumber") String[] manufacturerPartNumber,
            @RequestParam(value = "車種") String[] 車種,
            Model model) {
        int countC = 0;
        int countD = 0;
        for (int i = 0; i < cdnewQty.length; i++) {
            if (cdnewQty[i].equals("D")) {
                countD = countD + 1;
                for (int j = 0; j < stt.length; j++) {
                    if ( j == i ) {
                        carServiceImpl.delete( Long.parseLong(stt[j]) );
                    }
                }
            }
        }
        for (int i = 0; i < cdnewQty.length; i++) {
            if (cdnewQty[i].equals("C")) {
                countC = countC + 1;
                
                for (int j = 0; j < stt.length; j++) {
                    if ( j == i ) {
                        carServiceImpl.updateOneItem((stt[j]), メーカー[j], メーカー名[j], SS[j], SS名[j], 搬入場所[j], newQty[j], oldQty[j],manufacturerPartNumber[j],車種[j] );
                    }
                }
            }
        }
        model.addAttribute("successD",countD);
        model.addAttribute("success",countC);
        return "redirect:/index";
    }
}
