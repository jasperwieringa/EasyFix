package com.main.easyFix.usedpart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UsedPartResponseBody {
  String msg;
  List<UsedPart> usedParts;
}