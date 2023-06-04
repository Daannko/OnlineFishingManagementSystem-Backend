package com.ofms.AOP;

import com.ofms.dto.AllFishResponse;
import com.ofms.models.Fish;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import netscape.javascript.JSObject;
import org.apache.tomcat.util.json.JSONParser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Aspect
@Component
public class DataAspect {

    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    private String endpoint;
    private Fish fish;
    private HashMap<String,DataStatistics> endpoints = new HashMap<>();
    int allEndpointsRequests;

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void restControllers() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.GetMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.PostMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.PatchMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.PutMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.DeleteMapping)"
    )
    public void mappingAnnotations() {}

    @Pointcut("execution(@(@org.springframework.web.bind.annotation.RequestMapping *) * *(..))")
    public void requestMappingAnnotations() { }

    @Before("restControllers() && requestMappingAnnotations()")
    public void requestStatistics(JoinPoint jp){
        endpoint = request.getRequestURL().toString().replace("http://localhost:8080","");
        if (!endpoints.containsKey(endpoint)) {
            endpoints.put(endpoint, new DataStatistics());
        }
        endpoints.get(endpoint).allRequests++;
    }

    @AfterReturning(pointcut = "@within(org.springframework.stereotype.Controller) || @within(org.springframework.web.bind.annotation.RestController)", returning = "result")
    public void logResponse(JoinPoint joinPoint, Object result) {
        ResponseEntity<?> responseEntity = (ResponseEntity<?>) result;
        int status = responseEntity.getStatusCode().value();
        System.out.println(status);
        if(endpoints.containsKey(endpoint))
        if(status>199 && status <300){
            endpoints.get(endpoint).success++;
        }
        else {
            endpoints.get(endpoint).fail++;
        }

//        for(Map.Entry<String,DataStatistics> map : endpoints.entrySet()){
//            System.out.println(map.getKey());
//            System.out.println("\tAll requests: " + map.getValue().allRequests);
//            System.out.println("\tSuccess : " + map.getValue().success);
//            System.out.println("\tFail: " + map.getValue().fail);
//        }
    }
    @AfterReturning(pointcut = "@annotation(MaxWeight)", returning = "result")
    public void fishWeight(JoinPoint joinPoint, Object result) {
        ResponseEntity<?> responseEntity = (ResponseEntity<?>) result;
        for(AllFishResponse allFishResponse : (ArrayList<AllFishResponse>) Objects.requireNonNull(responseEntity.getBody())){
            if(fish == null) fish = allFishResponse.getFish();
            else {
                Fish f = allFishResponse.getFish();
                if(f.getWeight() > fish.getWeight()){
                    fish = f;
                }
            }
        }
        System.out.println("Biggest fish weight:" + fish.getWeight());

    }

    public HashMap<String, DataStatistics> getMap(){
        return endpoints;
    }
    public Fish getFish(){
        return fish;
    }

}