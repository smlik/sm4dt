import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../employee.service";
import {take} from "rxjs/operators";

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.scss']
})
export class AddEmployeeComponent implements OnInit {
  email = new FormControl('', [Validators.required, Validators.email]);
  addEmployee: FormGroup;
  submitted = false;

  constructor(private dialogRef: MatDialogRef<AddEmployeeComponent>, private formBuilder: FormBuilder, private employeeService: EmployeeService) {
    this.addEmployee = this.formBuilder.group({
      id: 0,
      firstName: ['', [Validators.required, Validators.pattern('[a-zA-Z]{2}')]],
      lastName: ['', [Validators.required, Validators.pattern('[a-zA-Z]{2}')]],
      email: ['', [Validators.required, Validators.pattern('^(([^<>()[\\]\\\\.,;:\\s@\\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\\"]+)*)|(\\".+\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$')]],
      phoneNumber: ['', [Validators.required, Validators.pattern('^([0-9]+-)+[0-9]+$')]],
      hireDate: ['', [Validators.required]],
      salary: [1, [Validators.required]],
    })
  }

  ngOnInit(): void {
  }

  get f(): { [key: string]: AbstractControl } {
    return this.addEmployee.controls;
  }

  addNewEmployee(): void {
    this.submitted = true;
   if (this.addEmployee.invalid) {
     return;
   }
   this.employeeService.saveEmployee(this.addEmployee.value).pipe(take(1)).subscribe(res => {
     this.dialogRef.close(true);
   },error => console.log(error))
  }
}
