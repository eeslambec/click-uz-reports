package uz.click.clickuzreports.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import uz.click.clickuzreports.entity.enums.ServiceCategory;

public class Service {
        private Long id;
        private String name;
        @Enumerated(EnumType.STRING)
        private ServiceCategory category;
        private Boolean isMaintenance;
        private String url;
        private Integer cashback;
        private Double longitude;
        private Double latitude;
        private Form form;
}
