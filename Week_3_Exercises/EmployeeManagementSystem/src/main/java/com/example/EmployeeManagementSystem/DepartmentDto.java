package com.example.EmployeeManagementSystem;

public class DepartmentDto {
	 private Long Id;
	    private String Name;

	    public DepartmentDto(Long id, String name) {
	        this.Id = id;
	        this.Name = name;
	    }

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			this.Id = id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			this.Name = name;
		}
}
