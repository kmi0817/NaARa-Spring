package kmi0817.naara.webclient;

import kmi0817.naara.hospital.domain.Hospital;
import kmi0817.naara.webclient.dto.ApiResponse;
import kmi0817.naara.webclient.dto.Item;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class WebClientService {

    private final WebClient webClient;
    @Value("${webclient.scheme}")
    private String scheme;
    @Value("${webclient.host}")
    private String host;
    @Value("${webclient.path}")
    private String path;
    @Value("${webclient.serviceKey}")
    private String serviceKey;
    @Value("${webclient.type}")
    private String type;

    public WebClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Hospital> callHospitalApi() {
        log.info("WebClientService > callHospitalApi");
        try {
            ApiResponse result = webClient.mutate()
                    .build()
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .scheme(scheme)
                            .host(host)
                            .path(path)
                            .queryParam("ServiceKey", serviceKey)
                            .queryParam("_type", type)
                            .build())
                    .retrieve()
                    .bodyToMono(ApiResponse.class)
                    .block();

            log.info("items = {}", Objects.requireNonNull(result).getResponse().getBody().getItems().getItem());
            List<Item> items = result.getResponse().getBody().getItems().getItem();
            return convertItemToHospital(items);
        } catch (Exception e) {
            //TODO Fix Error Handling

            log.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    private List<Hospital> convertItemToHospital(List<Item> items) {
        List<Hospital> hospitals = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        for (Item item: items) {
            hospitals.add(modelMapper.map(item, Hospital.class));
        }

        return hospitals;
    }

}
