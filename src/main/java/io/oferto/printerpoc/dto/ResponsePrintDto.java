package io.oferto.printerpoc.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class ResponsePrintDto {
	private String id;
	private String sampleId;
	private Date timestamp;
}
