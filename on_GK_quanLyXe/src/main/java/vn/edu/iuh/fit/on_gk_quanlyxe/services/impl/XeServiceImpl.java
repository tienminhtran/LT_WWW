package vn.edu.iuh.fit.on_gk_quanlyxe.services.impl;

import vn.edu.iuh.fit.on_gk_quanlyxe.dto.XeDTO;
import vn.edu.iuh.fit.on_gk_quanlyxe.entity.HangXe;
import vn.edu.iuh.fit.on_gk_quanlyxe.repositori.HangXeRepositori;
import vn.edu.iuh.fit.on_gk_quanlyxe.repositori.XeRepositori;
import vn.edu.iuh.fit.on_gk_quanlyxe.repositori.impl.HangXeRepositoriImpl;
import vn.edu.iuh.fit.on_gk_quanlyxe.repositori.impl.XeRepositoriImpl;
import vn.edu.iuh.fit.on_gk_quanlyxe.services.XeService;

import java.util.ArrayList;
import java.util.List;

public class XeServiceImpl implements XeService {

    private final HangXeRepositori hangXeRepositori;
    private final XeRepositori xeRepositori;


    public XeServiceImpl() {
        hangXeRepositori = new HangXeRepositoriImpl();
        xeRepositori = new XeRepositoriImpl();

    }


    @Override
    public List<XeDTO> getAllXe() {
        List<XeDTO> xeDTOS = new ArrayList<>();
        xeRepositori.getAlXe().forEach(xe -> {
            HangXe hangXe = hangXeRepositori.findHangXeById(xe.getMaHangXe().getMaHangXe());
            xeDTOS.add(new XeDTO(xe.getMaXe(), xe.getTenXe(), xe.getGiaXe(), xe.getNamSX(), hangXe.getTenHangXe()));
        });
        return xeDTOS;
    }

}
