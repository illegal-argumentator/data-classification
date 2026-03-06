package com.nick_brogden.data_classification.adapter.classification.in;

import com.nick_brogden.data_classification.application.classification.ClassificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/classification")
@RequiredArgsConstructor
public class ClassificationController {

    private final ClassificationUseCase useCase;

    // TODO process classification, in: csv file or array of strings
    @PostMapping
    public void process() {
//        useCase.process();
    }

}
