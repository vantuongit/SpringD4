package edu.vinaenter.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

		@NotEmpty(message = "tên k dc rỗng")
		private String name;
		
		@NotEmpty(message = "địa chỉ k dc rỗng")
		private String address;
		
		private String picture;
		
}
