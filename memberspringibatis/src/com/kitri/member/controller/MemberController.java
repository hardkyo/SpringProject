package com.kitri.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipDto;
import com.kitri.member.service.MemberService;
import com.kitri.util.Encoding;

@Controller
@RequestMapping("/user")
//@SessionAttributes("user")
public class MemberController {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value="/register.kitri", method=RequestMethod.GET)
	public String register() {
		return "/join/member";
	}
	
	@RequestMapping(value ="/register.kitri", method=RequestMethod.POST )
	public ModelAndView register(MemberDetailDto memberDetailDto) {
		ModelAndView mav = new ModelAndView();
		int cnt = memberService.register(memberDetailDto);
		mav.addObject("user",memberDetailDto);
		mav.setViewName("/WEB-INF/join/registerok");
		return mav;
	}
	
	@RequestMapping(value="/login.kitri", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
	@RequestMapping(value="/login.kitri", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/login/loginfail");
		MemberDto memberDto = memberService.login(map);
		if (memberDto != null) {
//			mav.addObject("user", memberDto);
			session.setAttribute("user", memberDto);
			mav.setViewName("/WEB-INF/login/loginok");
			//redirect로 해도 상관없다.
		}
		return mav;
	}
	
	@RequestMapping(value="/mail.kitri", method=RequestMethod.GET)
	public String mail() {
		return "/WEB-INF/login/mail";
	}
	
	@RequestMapping(value="/logout.kitri", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "/index";
	}
	
	
	/*@RequestMapping(value="/login.kitri", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("pass") String pass) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/login/loginfail");
		MemberDto memberDto = memberService.login(id, pass);
		if(memberDto != null) {
			mav.addObject("user", memberDto);
			mav.setViewName("/WEB-INF/login/loginok");
		}
		return mav;
	}*/
	
	@RequestMapping("/idcheck.kitri")
	public @ResponseBody String idcheck(@RequestParam("sid") String sid) {
		int cnt = memberService.idCheck(sid);
		JSONObject json = new JSONObject();//{}
		json.put("count", cnt);//{'count' : '1'}
		json.put("sid", sid);//{'count' : '1', 'sid' : 'java2'}
		//System.out.println(json.toJSONString());
		return json.toJSONString();
	}
	
	@RequestMapping(value="/zipsearch.kitri", method=RequestMethod.GET)
	public String zipsearch() {
		return "/WEB-INF/join/zipsearch";
	}
	
	@RequestMapping(value="/zipsearch.kitri", method=RequestMethod.POST)
	public @ResponseBody String zipsearch(@RequestParam("sdong") String sdong) {
		System.out.println("검색동 : " + sdong);
		List<ZipDto> list = memberService.zipSearch(sdong);
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		for(ZipDto zipDto : list) {
			JSONObject jsonaddr = new JSONObject();
			jsonaddr.put("zip1", zipDto.getZip1());
			jsonaddr.put("zip2", zipDto.getZip2());
			jsonaddr.put("address", Encoding.urlUtf(zipDto.getSido() + " " + zipDto.getGugun() + " " + zipDto.getDong() + " " + zipDto.getBunji()));
			
			jarr.add(jsonaddr);
		}
		json.put("ziplist", jarr);
		return json.toJSONString();
	}
}


