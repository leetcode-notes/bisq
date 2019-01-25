/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.core.trade.protocol.tasks.seller_as_taker;

import bisq.core.trade.Trade;
import bisq.core.trade.messages.PublishDepositTxRequest;
import bisq.core.trade.protocol.tasks.TradeTask;

import bisq.common.taskrunner.TaskRunner;

import lombok.extern.slf4j.Slf4j;

import static bisq.core.util.Validator.checkTradeId;
import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
public class SellerAsTakerProcessPublishDepositTxMessage extends TradeTask {
    @SuppressWarnings({"WeakerAccess", "unused"})
    public SellerAsTakerProcessPublishDepositTxMessage(TaskRunner taskHandler, Trade trade) {
        super(taskHandler, trade);
    }

    @Override
    protected void run() {
        log.warn("Missing impl.: SellerAsTakerProcessPublishDepositTxMessage");
        try {
            runInterceptHook();
            log.debug("current trade state " + trade.getState());
            PublishDepositTxRequest message = (PublishDepositTxRequest) processModel.getTradeMessage();
            checkTradeId(processModel.getOfferId(), message);
            checkNotNull(message);

            complete();
        } catch (Throwable t) {
            failed(t);
        }
    }
}
