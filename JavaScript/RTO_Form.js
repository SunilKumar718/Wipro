 (function(){
      const form = document.getElementById('rtoForm');
      const submitBtn = document.getElementById('submitBtn');
      const progressBar = document.getElementById('progressBar');
      const progressText = document.getElementById('progressText');
      const sections = Array.from(document.querySelectorAll('[data-section]'));

      const isHypo = document.getElementById('isHypo');
      const hypoFields = document.getElementById('hypoFields');
      const bank = document.getElementById('bank');
      const agreementDate = document.getElementById('agreementDate');

      const dob = document.getElementById('dob');
      const yom = document.getElementById('yom');
      const purchaseDate = document.getElementById('purchaseDate');
      const insExpiry = document.getElementById('insExpiry');
      const pucTill = document.getElementById('pucTill');

      const fileInputs = [
        {el: document.getElementById('idProof'), required: true, mime:['application/pdf','image/jpeg','image/png'], max: 2*1024*1024},
        {el: document.getElementById('insCopy'), required: true, mime:['application/pdf','image/jpeg','image/png'], max: 2*1024*1024},
        {el: document.getElementById('vehImage'), required: false, mime:['image/jpeg','image/png'], max: 2*1024*1024}
      ];

      const captchaQ = document.getElementById('captchaQ');
      const captchaA = document.getElementById('captchaA');
      const refreshCaptcha = document.getElementById('refreshCaptcha');
      let captchaAnswer = null;

      function genCaptcha(){
        const a=Math.floor(1+Math.random()*9), b=Math.floor(1+Math.random()*9);
        captchaAnswer = a + b;
        captchaQ.value = `${a} + ${b} = ?`;
        captchaA.value = '';
        captchaA.classList.remove('is-valid','is-invalid');
      }

      function todayStr(){
        const t = new Date();
        const mm = String(t.getMonth()+1).padStart(2,'0');
        const dd = String(t.getDate()).padStart(2,'0');
        return `${t.getFullYear()}-${mm}-${dd}`;
      }

      function setMaxDates(){
        const t = todayStr();
        dob.max = t;
        purchaseDate.max = t;
        insExpiry.min = t;
        pucTill.min = t;
        agreementDate.max = t;
      }

      function checkAge(){
        if(!dob.value) return false;
        const d = new Date(dob.value);
        const now = new Date();
        const age = now.getFullYear() - d.getFullYear() - ((now.getMonth()<d.getMonth() || (now.getMonth()==d.getMonth() && now.getDate()<d.getDate()))?1:0);
        const ok = age >= 18;
        setValidity(dob, ok);
        return ok;
      }

      function checkYom(){
        if(!yom.value) return false;
        const y = parseInt(yom.value,10);
        const cur = new Date().getFullYear();
        const ok = y >= 1980 && y <= cur;
        setValidity(yom, ok);
        return ok;
      }

      function checkPurchase(){
        if(!purchaseDate.value || !yom.value) { setValidity(purchaseDate, false); return false; }
        const p = new Date(purchaseDate.value);
        const now = new Date();
        const y = parseInt(yom.value,10);
        const ok = p <= now && p.getFullYear() >= y;
        setValidity(purchaseDate, ok);
        return ok;
      }

      function checkFuture(el){
        if(!el.value) return false;
        const d = new Date(el.value), now = new Date();
        const ok = d >= new Date(todayStr());
        setValidity(el, ok);
        return ok;
      }

      function setValidity(el, ok){
        el.classList.toggle('is-valid', !!ok);
        el.classList.toggle('is-invalid', !ok);
      }

      function validateFiles(){
        let allOk = true;
        for(const f of fileInputs){
          const el = f.el;
          let ok = !f.required && !el.files.length; 
          if(el.files.length){
            const file = el.files[0];
            ok = f.mime.includes(file.type) && file.size <= f.max;
          }
          setValidity(el, ok);
          if(!ok) allOk=false;
        }
        return allOk;
      }

      function validateFinance(){
        if(!isHypo.checked){
          bank.required = false; agreementDate.required = false;
          bank.value && bank.classList.remove('is-valid','is-invalid');
          agreementDate.value && agreementDate.classList.remove('is-valid','is-invalid');
          return true;
        }
        bank.required = true; agreementDate.required = true;
        const okBank = bank.value.trim().length > 1;
        const okDate = agreementDate.value && new Date(agreementDate.value) <= new Date();
        setValidity(bank, okBank);
        setValidity(agreementDate, okDate);
        return okBank && okDate;
      }

      function validateCaptcha(){
        if(!captchaA.value){ setValidity(captchaA,false); return false; }
        const ok = Number(captchaA.value) === captchaAnswer;
        setValidity(captchaA, ok);
        return ok;
      }

      function checkSectionValid(section){
        const controls = section.querySelectorAll('input, select, textarea');
        let ok = true;
        controls.forEach(c=>{
          if(c.hasAttribute('required')){
            if(!(c.checkValidity() && !c.classList.contains('is-invalid'))) ok=false;
          }
        });
        return ok;
      }

      function updateProgress(){
        let countValid = 0;
        sections.forEach(sec => { if(checkSectionValid(sec)) countValid++; });
        const pct = Math.round( (countValid / sections.length) * 100 );
        progressBar.style.width = pct + '%';
        progressBar.ariaValueNow = String(pct);
        progressText.textContent = `${pct}% complete`;
      }

      function updateSubmitState(){
        const formOK = form.checkValidity();
        const allSectionsOK = sections.every(checkSectionValid);
        const ok = formOK && allSectionsOK && validateCaptcha();
        submitBtn.disabled = !ok;
      }


      form.querySelectorAll('input,select,textarea').forEach(el=>{
        el.addEventListener('input', ()=>{ el.checkValidity(); updateProgress(); updateSubmitState(); });
        el.addEventListener('blur', ()=>{ el.classList.toggle('is-invalid', !el.checkValidity()); el.classList.toggle('is-valid', el.checkValidity()); updateProgress(); updateSubmitState(); });
        el.addEventListener('change', ()=>{ updateProgress(); updateSubmitState(); });
      });


      dob.addEventListener('change', ()=>{ checkAge(); updateProgress(); updateSubmitState(); });
      yom.addEventListener('input', ()=>{ checkYom(); checkPurchase(); updateProgress(); updateSubmitState(); });
      purchaseDate.addEventListener('change', ()=>{ checkPurchase(); updateProgress(); updateSubmitState(); });
      insExpiry.addEventListener('change', ()=>{ checkFuture(insExpiry); updateProgress(); updateSubmitState(); });
      pucTill.addEventListener('change', ()=>{ checkFuture(pucTill); updateProgress(); updateSubmitState(); });

      fileInputs.forEach(f=>{
        f.el.addEventListener('change', ()=>{ validateFiles(); updateProgress(); updateSubmitState(); });
      });

      isHypo.addEventListener('change', ()=>{
        hypoFields.hidden = !isHypo.checked;
        validateFinance();
        updateProgress();
        updateSubmitState();
      });
      bank.addEventListener('input', ()=>{ validateFinance(); updateProgress(); updateSubmitState(); });
      agreementDate.addEventListener('change', ()=>{ validateFinance(); updateProgress(); updateSubmitState(); });

      refreshCaptcha.addEventListener('click', ()=>{ genCaptcha(); updateSubmitState(); });
      captchaA.addEventListener('input', ()=>{ validateCaptcha(); updateSubmitState(); });

      form.addEventListener('submit', function(e){
        e.preventDefault();

        if(!form.checkValidity() || !validateCaptcha() || !validateFiles() || !validateFinance() || !checkAge() || !checkYom() || !checkPurchase() || !checkFuture(insExpiry) || !checkFuture(pucTill)){
          e.stopPropagation();
          form.classList.add('was-validated');
          updateProgress();
          updateSubmitState();
          return;
        }

        const toastEl = document.getElementById('successToast');
        const toast = bootstrap.Toast.getOrCreateInstance(toastEl);
        toast.show();

      });

      document.getElementById('resetBtn').addEventListener('click', ()=>{
        setTimeout(()=>{
          form.classList.remove('was-validated');
          form.querySelectorAll('.is-valid,.is-invalid').forEach(el=>el.classList.remove('is-valid','is-invalid'));
          genCaptcha();
          setMaxDates();
          hypoFields.hidden = true; isHypo.checked = false; bank.required=false; agreementDate.required=false;
          updateProgress(); updateSubmitState();
        }, 0);
      });
      genCaptcha();
      setMaxDates();
      updateProgress();
      updateSubmitState();
    })();