package com.MO.Software.Day.DTO;

import java.util.HashSet;
import java.util.stream.Collectors;

import com.MO.Software.Bill.DTO.billDTO;
import com.MO.Software.Bill.DTO.billDTOMapper;
import com.MO.Software.Day.dayModel;

public class dayDTOMapper {

	public static dayDTO mapDayModelTODTO(dayModel day)
	{
		dayDTO dto=new dayDTO();
		dto.setId(day.getId());
		dto.setDate(day.getDate());
		dto.setBills(new HashSet<billDTO>(day.getBills().stream().map(billDTOMapper::mapBillModelTOBillDTO).collect(Collectors.toList())));
		dto.setTotalBillsBuyCost(day.getTotalBillsBuyCost());
		dto.setTotalBillsCost(day.getTotalBillsCost());
		return dto;
	}
}
