package com.example.pethospital.controller;

import com.example.pethospital.message.MessageBean;
import com.example.pethospital.message.MessageCodeEnum;
import com.example.pethospital.pojo.Vaccinum;
import com.example.pethospital.service.VaccinumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class VaccinumController {
    @Resource
    private VaccinumService vaccinumService;

    // 获取全部疫苗接口
    @GetMapping("/vaccinum/all")
    public MessageBean<?> getAllVaccinums() {
        List<Vaccinum> data = vaccinumService.selectAllVaccinum();
        return new MessageBean<>(MessageCodeEnum.OK, data);
    }

    // 添加疫苗接口
    @PostMapping("/vaccinum/add")
    public MessageBean<?> addVaccinum(@RequestBody Vaccinum vaccinum) {
        vaccinumService.addVaccinum(vaccinum);
        return new MessageBean<>(MessageCodeEnum.OK, "添加疫苗成功");
    }

    // 根据疫苗ID删除疫苗接口
    @DeleteMapping("/vaccinum/delete/{vaccinumId}")
    public MessageBean<?> deleteVaccinumById(@PathVariable int vaccinumId) {
        vaccinumService.deleteVaccinumById(vaccinumId);
        return new MessageBean<>(MessageCodeEnum.OK, "删除疫苗成功");
    }

    // 更新疫苗接口
    @PutMapping("/vaccinum/update")
    public MessageBean<?> updateVaccinum(@RequestBody Vaccinum vaccinum) {
        vaccinumService.updateVaccinum(vaccinum);
        return new MessageBean<>(MessageCodeEnum.OK, "更新疫苗成功");
    }

    // 根据疫苗名称模糊查询接口
    @GetMapping("/vaccinum/searchByName")
    public MessageBean<?> getVaccinumsByName(@RequestParam String vaccinumName) {
        List<Vaccinum> data = vaccinumService.getVaccinumsByName(vaccinumName);
        return new MessageBean<>(MessageCodeEnum.OK, data);
    }

    // 根据疫苗ID查询接口
    @GetMapping("/vaccinum/searchById")
    public MessageBean<?> getVaccinumById(@RequestParam int vaccinumId) {
        Vaccinum data = vaccinumService.selectById(vaccinumId);
        return new MessageBean<>(MessageCodeEnum.OK, data);
    }
}
