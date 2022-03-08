package kr.co.todaydaeng;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.todaydaeng.board.model.vo.Board;
import kr.co.todaydaeng.common.MainPrint;
import kr.co.todaydaeng.common.SHA256Util;
import kr.co.todaydaeng.myPage.model.vo.Dog;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MainPrint mPrint;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//최신글 3개를 ArrayList로 메인에 전달
		ArrayList<Board> list = mPrint.printCommunityBoard();	
		
		//최신프로필 3개를 ArrayList로 메인에 전달
		ArrayList<Dog> dogList = mPrint.printDogProfile();	
		
		//model 객체를 이용
		model.addAttribute("list",list);
		model.addAttribute("dlist",dogList);
				
		model.addAttribute("serverTime", formattedDate );
		
//<<<<<<< HEAD

		return "index";
//=======
		//return "indexPage";
//>>>>>>> 4cf2926bae90cd94425735eec0245dc3e29bc714
	}
	
}
