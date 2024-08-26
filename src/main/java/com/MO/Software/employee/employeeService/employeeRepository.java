package com.MO.Software.employee.employeeService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.employee.employeeModel;
import com.MO.Software.employee.DTO.employeeDTO;

@Repository
public interface employeeRepository  extends baseRepository<employeeModel, Long>{

	@Query("SELECT emp from employeeModel emp where emp.name=:employeeName")
	employeeModel findByName(@Param("employeeName") String employeeName);

	@Query("SELECT emp from employeeModel emp where emp.jobTypeModel.name Like%:jobTypeName%")
	List<employeeModel> findByJobTypeModelName(String jobTypeName);

	@Query("SELECT emp from employeeModel emp where emp.jobTypeModel.id=:jobTypeId")
	List<employeeModel> findByJobTypeModelId(Long jobTypeId);

    @Query("SELECT e " +
            "FROM employeeModel e " +
            "WHERE (:empName IS NULL OR e.name = :empName) " +
            "AND (:salary IS NULL OR e.salary = :salary) " +
            "AND (:fetchedEmployeesIds IS NULL OR e.id IN :fetchedEmployeesIds) " +
            "")
     List<employeeModel> findEmployeeModel(@Param("empName") String empName,
                                         @Param("salary") Integer salary,
                                         @Param("fetchedEmployeesIds") List<Long> fetchedEmployeesIds
    		 								);

}
