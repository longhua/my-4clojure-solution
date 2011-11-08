; Re-implement Iterate
; Given a side-effect free function f and an initial value x
; write a function which returns an infinite lazy sequence of
; x, (f x), (f (f x)), (f (f (f x))), etc.

(fn my-iterate [f initial]
  (lazy-seq (cons initial
                  (my-iterate f (f initial)))))
