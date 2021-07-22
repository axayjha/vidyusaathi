import { ValidatorFn, AbstractControl, FormGroup, ValidationErrors } from '@angular/forms';

export const equalityChecker: ValidatorFn = (
         control: FormGroup
       ): ValidationErrors | null => {
         const password = control.get('password');
         const repassword = control.get('rePassword');
         return password && repassword && password.value === repassword.value ?
         null : {isequal : true}
         ;
       };
