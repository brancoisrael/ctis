<style>
.bd-example-modal-lg .modal-dialog{
    display: table;
    position: relative;
    margin: 0 auto;
    top: calc(50% - 24px);
  }
  
  .bd-example-modal-lg .modal-dialog .modal-content{
    background-color: transparent;
    border: none;
  }
</style>

<div class="modal fade bd-example-modal-lg" id="loadingModal" data-backdrop="static" data-keyboard="false" tabindex="-1">
    <div class="modal-dialog modal-sm">
        <div class="modal-content" style="width: 48px">
            <span class="fa fa-spinner fa-spin fa-3x" style="color: white;"></span>
        </div>
    </div>
</div>
<script type="text/javascript">
function openLoading() {
	$('#loadingModal').modal('show');
}
function closeLoading() {
	$('#loadingModal').modal('hide');
}
</script>
	