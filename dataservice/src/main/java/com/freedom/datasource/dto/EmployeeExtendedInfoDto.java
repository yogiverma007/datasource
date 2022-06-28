package com.freedom.datasource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeExtendedInfoDto {
  public Long salary;
  public String alternateContact;
}
