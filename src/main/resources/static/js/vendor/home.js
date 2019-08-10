require(['./jqthumb.min'], function () {
    $('#scroll_banner .banner_img').jqthumb({
        width: '100%',
        height: '100%',
        position: {
            x: '50%',
            y: '20%'
        },
        source: 'data-cover'
    });
});