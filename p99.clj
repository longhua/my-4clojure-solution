; Product Digits
; Write a function which multiplies two numbers and returns
; the result as a sequence of its digits.
;
(fn [x y]
  (map #(- (int %) (int \0))
       (pr-str (* x y))))
