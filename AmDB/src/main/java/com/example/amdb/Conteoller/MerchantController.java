package com.example.amdb.Conteoller;

import com.example.amdb.Model.Category;
import com.example.amdb.Model.Merchant;
import com.example.amdb.Service.MerchantService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchant")
public class MerchantController {

private final MerchantService merchantService;
@GetMapping("/get")
    public ResponseEntity getAllMerchant() {
        return ResponseEntity.status(200).body(merchantService.getMerchant());
    }
@PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("added Merchant");
    }

@PutMapping("/put/{id}")
    public ResponseEntity updateMerchant(@Positive Integer id, @RequestBody @Valid Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.updateMerchant(id, merchant);
        return ResponseEntity.status(200).body("Update Merchant");
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@Positive Integer id) {
        boolean isDelete = merchantService.deleteMerchant(id);
        if (isDelete) {
            return ResponseEntity.status(200).body("Delete Merchant");
        }
        return ResponseEntity.status(400).body("Not delete ");
    }
}
