package kmi0817.naara.webclient.dto;

import kmi0817.naara.hospital.domain.Hospital;
import lombok.Getter;

import java.util.List;

@Getter
public class ApiResponse {
    private HospitalResponse response;

    @Getter
    public static class HospitalResponse {
        private HospitalBody body;

        @Getter
        public static class HospitalBody {
            private Items items;
            private int numOfRows;
            private int pageNo;
            private int totalCount;

            @Getter
            public static class Items {
                private List<Hospital> item;
            }
        }
    }
}
