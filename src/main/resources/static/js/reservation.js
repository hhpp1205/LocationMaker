$(document).ready(function () {

    const placeSelect = $('#place-select');
    const placeTxtArea = $('#place-text-area');

    placeSelect.on('change', function () {

        if (placeSelect.val() === 'self' && !placeTxtArea.hasClass('self-write-on')){
            const placeInputArea = `<div class="input-group mt-1" id="place-input-area" style="width: 90%">
                            <input type="text" class="form-control place-input" placeholder="장소를 입력해주세요." aria-label="장소를 입력해주세요.">
                            <button class="btn btn-outline-secondary" type="button" id="place-addon">결정</button>
                            <button class="btn btn-outline-secondary" type="button" id="place-cancel">취소</button>
                            </div>`;
            placeTxtArea.append(placeInputArea);
            placeTxtArea.addClass('self-write-on');

        } else if (placeSelect.val() !== 'self' && placeTxtArea.hasClass('self-write-on')){
            console.log("test");
            placeTxtArea.empty();
            placeTxtArea.removeClass('self-write-on');
        }
    });

    placeTxtArea.on('click',function (e) {
       const target = e.target;

       console.log(target.id);

       if (target.id === 'place-addon' && !placeSelect.hasClass('rock-on')) {
           placeSelect.attr('disabled', 'disabled');
           placeSelect.addClass('rock-on');
           placeTxtArea.find('input').attr('readonly', 'true');

           const reserveComment = `<span> * 장소가 선택되었습니다. </span>`;
           placeTxtArea.append(reserveComment);
       } else if (target.id === 'place-cancel' && placeSelect.hasClass('rock-on')) {
           placeSelect.removeAttr('disabled');
           placeSelect.removeClass('rock-on');
           placeTxtArea.find('input').removeAttr('readonly');
           placeTxtArea.find('span').remove();
       }
    });

});


