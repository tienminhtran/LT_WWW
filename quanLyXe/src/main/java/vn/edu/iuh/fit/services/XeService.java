/**
 * @ (#) XeService.java      10/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.dtos.XeDTO;
import vn.edu.iuh.fit.entities.HangXe;

import java.util.List;


public interface XeService {
    public List<XeDTO> getXeDTOs();
    public List<XeDTO> getXeDTOByTen(String tenXe);
    public boolean save(XeDTO xe);
    public boolean update(XeDTO xe);
    public boolean delete(long id);
    public XeDTO getOne(long id);

    public List<HangXe> getAllHangXe();

 }
