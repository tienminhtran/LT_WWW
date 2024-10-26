package vn.edu.iuh.fit.on_gk_quanlyxe.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class XeDTO {
    private String maXe;
    private String tenXe;
    private Long giaXe;
    private String namSX;

    private String hangXe;

    public XeDTO() {
    }

    public XeDTO(String maXe, String tenXe, Long giaXe, String namSX, String hangXe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
        this.hangXe = hangXe;
    }





}
