package com.luv2code.cruddemo.gateway;

import com.luv2code.cruddemo.Exceptions.DipExceptionHandler;
import com.luv2code.cruddemo.entity.Address;
import com.luv2code.cruddemo.entity.EducationalDetails;
import com.luv2code.cruddemo.entity.FamilyDetails;
import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.webclient.WebCleintClass;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class Gateway {

    private final WebCleintClass webCleintClass;

    public Mono<Address> addressGateway(Integer id) {

        var uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/address/{id}")
                .buildAndExpand(id)
                .toUriString();
        return webCleintClass.webClient()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Address.class)
                .onErrorResume(throwable ->
                        Mono.error(DipExceptionHandler.builder()
                                .time(LocalDateTime.now())
                                .message(throwable.getMessage())
                                .statusCode(HttpStatus.NOT_FOUND.value())
                                .build()));
    }


    public Mono<Student> studentGateway(Integer id) {

        var uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/getStudents/{id}")
                .buildAndExpand(id)
                .toUriString();

        return webCleintClass.webClient()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Student.class)
                .onErrorResume(throwable -> {
                    return Mono.error(throwable.getCause());
                });
    }

    public Mono<EducationalDetails> educationalDetails(Integer id) {

        var uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/educationaldetails/getEducationalDetails/{id}")
                .buildAndExpand(id)
                .toUriString();

        return webCleintClass.webClient()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(EducationalDetails.class)
                .onErrorResume(throwable ->
                        Mono.error(throwable.getCause()));
    }

    public Mono<FamilyDetails> familyDetailsMono(Integer id) {

        var uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/familydetails/{id}")
                .buildAndExpand(id)
                .toUriString();

        return webCleintClass.webClient()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(FamilyDetails.class)
                .onErrorResume(throwable ->
                        Mono.error(throwable.getCause()));
    }
}
