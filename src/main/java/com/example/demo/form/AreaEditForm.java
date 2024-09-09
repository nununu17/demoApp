package com.example.demo.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AreaEditForm implements Serializable{
	
	@Pattern(regexp="[1-8]", message="適切な値を選択してください")
	private String num;
	
	@NotEmpty(message="入力されていません。変更を実行しない場合も、既存の値を記入してください")
	@Size(min = 1, max=20, message="1~20文字で入力してください")
	private String name; 
	
	@NotEmpty(message="入力されていません。変更を実行しない場合も、既存の値を記入してください")
	@Size(min=1, max=20, message="1~20文字で入力してください")
	private String dispName;

}
