function likeJoke(elem) {
    var $elem = $(elem);
    if ($elem.hasClass('clicked')) {
        return;
    }

    var data = {
        id: $elem.data('joke-id')
    }

    $.ajax({
        url: '/like',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
        dataType: 'json',
        success: function() {
            var $th = $elem.closest('th');
            $th.find('i').addClass('clicked');

            var $tr = $th.closest('tr');
            var $likes = $tr.find('td.likes');
            var count = parseInt($likes.text()) + 1;
            $likes.text(count);
        },

    });
}

function dislikeJoke(elem) {
    var $elem = $(elem);
    if ($elem.hasClass('clicked')) {
        return;
    }

    var data = {
        id: $elem.data('joke-id')
    }

    $.ajax({
        url: '/dislike',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
        dataType: 'json',
        success: function() {
            var $th = $elem.closest('th');
            $th.find('i').addClass('clicked');

            var $tr = $th.closest('tr');
            var $dislikes = $tr.find('td.dislikes');
            var count = parseInt($dislikes.text()) + 1;
            $dislikes.text(count);
        },

    });
}