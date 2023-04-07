package com.example.pethospital.service.impl;

import com.example.pethospital.mapper.VaccinumMapper;
import com.example.pethospital.pojo.Vaccinum;
import com.example.pethospital.service.VaccinumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class VaccinumServiceImpl implements VaccinumService {

    @Resource
    private VaccinumMapper vaccinumMapper;

    @Override
    public void addVaccinum(Vaccinum vaccinum) {
        vaccinumMapper.addVaccinum(vaccinum);
    }

    @Override
    public List<Vaccinum> selectAllVaccinum() {
        return vaccinumMapper.selectAllVaccinum();
    }

    @Override
    public Vaccinum selectById(int vaccinumId) {
        return vaccinumMapper.selectById(vaccinumId);
    }

    @Override
    public List<Vaccinum> getVaccinumsByName(String vaccinumName) {
        return vaccinumMapper.selectByNameLike(vaccinumName);
    }

    @Override
    public void deleteVaccinumById(int vaccinumId) {
        vaccinumMapper.deleteVaccinumById(vaccinumId);
    }

    @Override
    public void updateVaccinum(Vaccinum vaccinum) {
        vaccinumMapper.updateById(vaccinum);
    }
}
