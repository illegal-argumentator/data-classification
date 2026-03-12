package com.nick_brogden.data_classification.port;

public interface CsvExporter<T> {

    byte[] export(T data);

}
