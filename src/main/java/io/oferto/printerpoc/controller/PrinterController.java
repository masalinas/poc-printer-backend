package io.oferto.printerpoc.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.oferto.printerpoc.dto.ResponsePrintDto;
import io.oferto.printerpoc.service.PrinterService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class PrinterController {
	private final PrinterService printerService;
	
	@GetMapping(
		value = "/print",		
		produces = MediaType.APPLICATION_PDF_VALUE
	)	
	public @ResponseBody byte[] index(@RequestParam(required = true) String sampleId) throws IOException {
		ByteArrayOutputStream fileStream = printerService.generateReport(sampleId);
				
		ResponsePrintDto responsePrintDto = 
		 	ResponsePrintDto.builder()
				.id("1")
				.sampleId(sampleId)
				.timestamp(new Date()).build();	
				
		return fileStream.toByteArray();
	}
}
