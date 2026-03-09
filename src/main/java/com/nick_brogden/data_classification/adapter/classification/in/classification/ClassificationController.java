package com.nick_brogden.data_classification.adapter.classification.in.classification;

import com.nick_brogden.data_classification.adapter.classification.in.classification.dto.ClassificationRequest;
import com.nick_brogden.data_classification.application.classification.ClassificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/classification")
@RequiredArgsConstructor
public class ClassificationController {

    private final ClassificationUseCase useCase;

    @PostMapping("/process")
    public void process(@RequestBody @Valid ClassificationRequest request) {
        useCase.process(request.email(), request.domains());
    }

}
