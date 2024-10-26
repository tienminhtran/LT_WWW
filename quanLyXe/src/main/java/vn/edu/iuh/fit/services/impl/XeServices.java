/**
 * @ (#) XeServices.java      10/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.services.impl;

import vn.edu.iuh.fit.dtos.XeDTO;
import vn.edu.iuh.fit.entities.HangXe;
import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.HangXeRepositories;
import vn.edu.iuh.fit.repositories.XeRepositories;
import vn.edu.iuh.fit.repositories.impl.HangXeRepositoriesImpl;
import vn.edu.iuh.fit.repositories.impl.XeRepositoriesImpl;
import vn.edu.iuh.fit.services.XeService;

import java.util.ArrayList;
import java.util.List;


public class XeServices implements XeService{
    private final XeRepositories xeRepositories;
    private final HangXeRepositories hangXeRepositories;

    public XeServices() {
        xeRepositories = new XeRepositoriesImpl();
        hangXeRepositories = new HangXeRepositoriesImpl();
    }

    @Override
    public List<XeDTO> getXeDTOs() {
        List<XeDTO> xeDTOs = new ArrayList<>();
        xeRepositories.findAll().forEach(xe -> {
            HangXe hangXe = hangXeRepositories.findById(xe.getMaHangXe().getMaHangXe());
            xeDTOs.add(new XeDTO(xe.getMaXe(), xe.getTenXe(), xe.getGiaXe(), xe.getNamSX(), hangXe.getTenHangXe()));
        });
        return xeDTOs;
    }

    @Override
    public List<XeDTO> getXeDTOByTen(String tenXe) {
        List<XeDTO> xeDTOs = new ArrayList<>();
        xeRepositories.findByTenXe(tenXe).forEach(xe -> {
            HangXe hangXe = hangXeRepositories.findById(xe.getMaHangXe().getMaHangXe());
            xeDTOs.add(new XeDTO(xe.getMaXe(), xe.getTenXe(), xe.getGiaXe(), xe.getNamSX(), hangXe.getTenHangXe()));
        });
        return xeDTOs;
    }

    @Override
    public boolean save(XeDTO xe) {
        HangXe hangXe = hangXeRepositories.findByTenHangXe(xe.getHangXe());
        Xe xeEntity = new Xe(xe.getTenXe(), xe.getGiaXe(), xe.getNamSX());
        xeEntity.setMaHangXe(hangXe);
        return xeRepositories.save(xeEntity);
    }

    @Override
    public boolean update(XeDTO xe) {
        HangXe hangXe = hangXeRepositories.findByTenHangXe(xe.getHangXe());
        Xe xeEntity = new Xe(xe.getMaXe(), xe.getTenXe(), xe.getGiaXe(), xe.getNamSX());
        xeEntity.setMaHangXe(hangXe);
        return xeRepositories.update(xeEntity);
    }

    @Override
    public boolean delete(long id) {
        return xeRepositories.delete(id);
    }

    @Override
    public XeDTO getOne(long id) {
        Xe xe = xeRepositories.findById(id);
        HangXe hangXe = hangXeRepositories.findById(xe.getMaHangXe().getMaHangXe());
        return new XeDTO(xe.getMaXe(), xe.getTenXe(), xe.getGiaXe(), xe.getNamSX(), hangXe.getTenHangXe());
    }

    @Override
    public List<HangXe> getAllHangXe() {
        return hangXeRepositories.findAll();
    }

    public static void main(String[] args) {
        XeService xeService = new XeServices();
        List<XeDTO> xeDTOs = xeService.getXeDTOByTen("Toyota");
        xeDTOs.forEach(xeDTO -> {
            System.out.println(xeDTO);
        });
    }
}
