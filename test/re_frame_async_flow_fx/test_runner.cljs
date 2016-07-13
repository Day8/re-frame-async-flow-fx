(ns re-frame-async-flow-fx.test-runner
  (:require
    [cljs.test :as cljs-test :include-macros true]
    [jx.reporter.karma :as karma :include-macros true]
    [devtools.core     :as devtools]
    ;; Test Namespaces -------------------------------
    [re-frame-async-flow-fx.core-test])
  (:refer-clojure :exclude (set-print-fn!)))

(enable-console-print!)
(devtools/install! [:custom-formatters :sanity-hints]) ;; we love https://github.com/binaryage/cljs-devtools

;; ---- BROWSER based tests ----------------------------------------------------
(defn ^:export set-print-fn! [f]
  (set! cljs.core.*print-fn* f))


(defn ^:export run-html-tests []
  (cljs-test/run-tests
    're-frame-async-flow-fx.core-test))

;; ---- KARMA  -----------------------------------------------------------------

(defn ^:export run-karma [karma]
  (karma/run-tests
    karma
    're-frame-async-flow-fx.core-test))
