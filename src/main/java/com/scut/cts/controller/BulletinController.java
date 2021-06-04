package com.scut.cts.controller;

import com.scut.cts.pojo.Bulletin;
import com.scut.cts.pojo.RespBean;
import com.scut.cts.service.BulletinService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bulletin")
public class BulletinController
{
	@Autowired
	private BulletinService bulletinService;

	@PostMapping
	public RespBean addBulletin(@RequestParam String content) {
		Bulletin bulletin = new Bulletin(content);
		boolean result ;
		try {
			result=bulletinService.addBulletin(bulletin);
		} catch (Exception e){
			return RespBean.unprocessable("公告创建失败"+e.getMessage(), bulletin);
		}
		if (result)
			return RespBean.created("公告创建成功", bulletin);
		return RespBean.unprocessable("公告创建失败", bulletin);
	}

	@PutMapping("/modify/{bulletinId}")
	public RespBean updateBulletin(@PathVariable int bulletinId,@RequestParam String content){
		Bulletin bulletin = new Bulletin(bulletinId, content);
		boolean result ;
		try {
			result=bulletinService.updateBulletin(bulletin);
		} catch (Exception e){
			return RespBean.unprocessable("更新失败"+e.getMessage(), bulletin);
		}
		if (result)
			return RespBean.ok("更新成功",bulletin);
		return RespBean.unprocessable("更新失败", bulletin);
	}

	@DeleteMapping("/{bulletinId}")
	public RespBean deleteBulletin(@PathVariable int bulletinId){
		boolean result ;
		try {
			result=bulletinService.deleteBulletin(bulletinId);
		} catch (Exception e){
			return RespBean.unprocessable("删除失败"+e.getMessage());
		}
		if (result)
			return RespBean.ok("删除成功");
		return RespBean.unprocessable("删除失败");
	}

	@GetMapping("/getAll")
	public RespBean getBulletin(){
		List<Bulletin> bulletinList = bulletinService.getAllBulletin();
		return RespBean.ok("获取成功",new BulletinList(bulletinList));
	}
}

@Data
class BulletinList{
	private List<Bulletin> bulletinList;

	public BulletinList(List<Bulletin> bulletinList) {
		this.bulletinList = bulletinList;
	}
}
